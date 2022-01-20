import { WebPlugin } from '@capacitor/core';

import { ChangeAppIconPlugin } from './definitions';

export class ChangeAppIconWeb extends WebPlugin implements ChangeAppIconPlugin {
  constructor() {
    super({
      name: 'ChangeAppIcon',
      platforms: ['web'],
    });
  }

  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
  async changeAppIcon(options: { name: string, allNames: string[] }): Promise<{ name: string, allNames: string[] }> {
    console.warn('Only native works ', options);
    return options;
  }
}


const ChangeAppIcon = new ChangeAppIconWeb();

export { ChangeAppIcon };

import { registerWebPlugin } from '@capacitor/core';
registerWebPlugin(ChangeAppIcon);
