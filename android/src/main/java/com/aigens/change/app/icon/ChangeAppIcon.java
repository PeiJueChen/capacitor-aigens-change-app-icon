package com.aigens.change.app.icon;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;

import com.getcapacitor.JSObject;
import com.getcapacitor.PluginCall;

import org.json.JSONException;

import java.util.List;

public class ChangeAppIcon {
    PackageManager mPackageManager;
    public String echo(String value) {
        Log.i("Echo", value);
        return value;
    }

    public void changeAppIcon(PluginCall call, Context baseContex, PackageManager mPackageManager) {
        String name = call.getString("name");
        if (name == null) {
            call.reject("Cann't find the Name field, android must set the name field");
            return;
        }

        Log.i("changeAppIcon", name);
        this.mPackageManager = mPackageManager;
        List<String> names = null;
        try {
            names = call.getArray("allNames").toList();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (names == null || names.size() == 0) {
            call.reject("Your names is empty");
            return;
        }

        for (String i : names) {
            if (!i.equals(name)) {
                ComponentName componentName = new ComponentName(baseContex, i);
                disableComponent(componentName);
            }
        }
        ComponentName targetComponentName = new ComponentName(baseContex, name);
        enableComponent(targetComponentName);
    }


    public void enableComponent(ComponentName componentName) {
        if (mPackageManager == null) return;
        mPackageManager.setComponentEnabledSetting(componentName,
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
    }


    public void disableComponent(ComponentName componentName) {
        if (mPackageManager == null) return;
        mPackageManager.setComponentEnabledSetting(componentName,
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
    }

}
