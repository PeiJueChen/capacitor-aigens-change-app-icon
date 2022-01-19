import { registerPlugin } from '@capacitor/core';

import type { ChangeAppIconPlugin } from './definitions';

const ChangeAppIcon = registerPlugin<ChangeAppIconPlugin>('ChangeAppIcon', {
  web: () => import('./web').then(m => new m.ChangeAppIconWeb()),
});

export * from './definitions';
export { ChangeAppIcon };
