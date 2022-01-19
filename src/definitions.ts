export interface ChangeAppIconPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
  changeAppIcon(options: { name: string, allNames: string[] }): Promise<{ name: string, allNames: string[] }>;
}
