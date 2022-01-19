import Foundation
import Capacitor

/**
 * Please read the Capacitor iOS Plugin Development Guide
 * here: https://capacitorjs.com/docs/plugins/ios
 */
@objc(ChangeAppIconPlugin)
public class ChangeAppIconPlugin: CAPPlugin {
    private let implementation = ChangeAppIcon()

    @objc func echo(_ call: CAPPluginCall) {
        let value = call.getString("value") ?? ""
        call.resolve([
            "value": implementation.echo(value)
        ])
    }

    @objc func changeAppIcon(_ call: CAPPluginCall) {
        let name = call.getString("name")
        print("icon name change to:\(name)")
        implementation.changeAppIcon(name, call);
        
    }
    
}
