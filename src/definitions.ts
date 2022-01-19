export interface ChangeAppIconPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
