module.exports = {
   dev: {
        proxyTable: {
            // proxy all requests starting with /api to jsonplaceholder
            '*': {
                target: 'http://localhost:8001',
                changeOrigin: true,
                pathRewrite: {
                    '^/api': ''
                }
            }
        }
    }
}