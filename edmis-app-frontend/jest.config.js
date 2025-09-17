/** @type {import('jest').Config} */
const config = {
  // Run this after setting up the test environment (setup DOM matchers, etc.)
  setupFilesAfterEnv: ["<rootDir>/jest.setup.js"],

  testEnvironment: "jsdom",

  // Use ts-jest to handle TypeScript files
  preset: "ts-jest",

  transform: {
    "^.+\\.tsx?$": [
      "ts-jest",
      {
        tsconfig: "tsconfig.app.json", // ✅ explicitly point to the correct config
        isolatedModules: true, // optional optimization
      },
    ],
  },

  // Recognize file types handled by Vite (JSX, TSX, CSS Modules, etc.)
  moduleFileExtensions: ["ts", "tsx", "js", "jsx", "json"],

  // Handle static assets and styles the way Vite does (mock them)
  moduleNameMapper: {
    "\\.(css|less|sass|scss)$": "identity-obj-proxy",
    "\\.(jpg|jpeg|png|gif|svg)$": "<rootDir>/__mocks__/fileMock.js",
    "^@/(.*)$": "<rootDir>/src/$1", // Optional alias support
  },

  testMatch: ["**/__tests__/**/*.[jt]s?(x)", "**/?(*.)+(spec|test).[jt]s?(x)"],

  collectCoverageFrom: [
    "src/**/*.{ts,tsx,js,jsx}",
    "!src/**/*.d.ts",
    "!src/**/index.{ts,tsx,js,jsx}",
    "!src/main.tsx",
    "!src/mocks/*.ts",
  ],

  verbose: true,
};

export default config;
