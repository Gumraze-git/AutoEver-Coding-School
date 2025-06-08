import { defineConfig } from "vite";
import vue from "@vitejs/plugin-vue";
import path from "path";

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue()],
  resolve: {
    alias: {
      // src 경로를 @로 대체
      "@": path.resolve(__dirname, "./src"),
    },
  },
});
