import { useState, useCallback } from "react";
import axios, { AxiosRequestConfig } from "axios";

interface IApiRequest {
  url: string;
  method?: "GET" | "POST" | "PUT" | "DELETE" | "PATCH";
  headers?: Record<string, string>;
  data?: any;
}

interface IApiResponse<T> {
  response: T | null;
  error: string | null;
  loading: boolean;
  makeRequest: (payload?: any) => Promise<void>;
}

export const useApi = <T = any>({
  url,
  method = "GET",
  headers = {},
  data = null,
}: IApiRequest): IApiResponse<T> => {
  const [response, setResponse] = useState<T | null>(null);
  const [error, setError] = useState<string | null>(null);
  const [loading, setLoading] = useState<boolean>(false);

  const makeRequest = useCallback(
    async (payload?: any) => {
      setLoading(true);
      setError(null);

      const config: AxiosRequestConfig = {
        url,
        method,
        headers,
        data: payload,
      };

      try {
        const res = await axios(config);
        setResponse(res.data);
      } catch (err) {
        setError(err instanceof Error ? err.message : "An error occurred");
      } finally {
        setLoading(false);
      }
    },
    [url, method, headers, data]
  );

  return { response, error, loading, makeRequest };
};
