package com.aigens.change.app.icon;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.NativePlugin;


@NativePlugin()
public class ChangeAppIconPlugin extends Plugin {

    private ChangeAppIcon implementation = new ChangeAppIcon();

    @PluginMethod
    public void echo(PluginCall call) {
        String value = call.getString("value");
        JSObject ret = new JSObject();
        ret.put("value", implementation.echo(value));
        call.resolve(ret);
    }

    @PluginMethod
    public void changeAppIcon(PluginCall call) {
        implementation.changeAppIcon(call, this.getActivity().getBaseContext(), this.getActivity().getPackageManager());
    }
}
