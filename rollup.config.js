export default {
  input: 'dist/esm/index.js',
  output: [
    {
      file: 'dist/plugin.js',
      format: 'iife',
      name: 'capacitorChangeAppIcon',
      globals: {
        '@capacitor/core': 'capacitorExports',
      },
      sourcemap: true,
    }
  ],
  external: ['@capacitor/core'],
};
