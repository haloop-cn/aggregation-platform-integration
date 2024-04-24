import {defineConfig} from "umi";

export default defineConfig({
  routes: [
    {path: "/", component: "index"},
  ],
  npmClient: 'pnpm',


  proxy: {
    '/api': {
      target: 'http://localhost:8899',
      changeOrigin: true,
      pathRewrite: {'^/api': ''},
    }
  }
});
