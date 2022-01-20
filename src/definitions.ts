export interface ChangeAppIconPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
  /**
   * 
   * @param options name: Your wanna change to xxx, allNames: for android
   */
  changeAppIcon(options: { name: string, allNames: string[] }): Promise<{ name: string, allNames: string[] }>;
}
