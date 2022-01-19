import { WebPlugin } from '@capacitor/core';

import type { ChangeAppIconPlugin } from './definitions';

export class ChangeAppIconWeb extends WebPlugin implements ChangeAppIconPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
