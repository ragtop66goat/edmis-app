// Optional: configure or set up a testing framework before each test.
// If you delete this file, remove `setupFilesAfterEnv` from `jest.config.js`
const { TextEncoder, TextDecoder } = require("util");
// Polyfill for TextEncoder and TextDecoder in Jest
global.TextEncoder = TextEncoder;
global.TextDecoder = TextDecoder;

// Used for __tests__/testing-library.js
// Learn more: https://github.com/testing-library/jest-dom
require("@testing-library/jest-dom/extend-expect");
require("whatwg-fetch");

const { server } = require("@/mocks/server");

// Establish API mocking before all tests.
beforeAll(() => server.listen());

// Reset any request handlers that we may add during the tests,
// so they don't affect other tests.
afterEach(() => server.resetHandlers());

// Clean up after the tests are finished.
afterAll(() => server.close());
