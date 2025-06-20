/** @type {import('jest').Config} */
const config = {
  // Run this after setting up the test environment (setup DOM matchers, etc.)
  setupFilesAfterEnv: ["<rootDir>/jest.setup.js"],

  testEnvironment: "jsdom",

  // Use ts-jest to handle TypeScript files
  preset: "ts-jest",

  globals: {
    "ts-jest": {
      tsconfig: "tsconfig.app.json", // 👈 point to your app config
    },
  },

  // Recognize file types handled by Vite (JSX, TSX, CSS Modules, etc.)
  moduleFileExtensions: ["ts", "tsx", "js", "jsx", "json"],

  // Handle static assets and styles the way Vite does (mock them)
  moduleNameMapper: {
    "\\.(css|less|sass|scss)$": "identity-obj-proxy",
    "\\.(jpg|jpeg|png|gif|svg)$": "<rootDir>/__mocks__/fileMock.js",
    "^@/(.*)$": "<rootDir>/src/$1", // Optional: if you're using aliases like @/
  },

  transform: {
    "^.+\\.tsx?$": "ts-jest",
  },

  testMatch: ["**/__tests__/**/*.[jt]s?(x)", "**/?(*.)+(spec|test).[jt]s?(x)"],

  collectCoverageFrom: [
    "src/**/*.{ts,tsx,js,jsx}",
    "!src/**/*.d.ts",
    "!src/**/index.{ts,tsx,js,jsx}", // optional: ignore barrel files
  ],

  verbose: true,
};

export default config;
