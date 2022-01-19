import Foundation
import Capacitor

@objc public class ChangeAppIcon: NSObject {
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }

    @objc public func changeAppIcon(_ name: String?, _ call: CAPPluginCall) {
        
        DispatchQueue.main.async {
            if !UIApplication.shared.supportsAlternateIcons {
                call.reject("not supportsAlternateIcons")
                return;
            }
            var isMain = false;
            var name_ = name
            if let n = name {
                if (n == "" || n == "main" || n == "Main") {
                    isMain = true;
                    name_ = nil;
                }
            }
            UIApplication.shared.setAlternateIconName(name_) { error in
                if error != nil {
                    print("change app icon error: \(String(describing: error?.localizedDescription))")
                    call.reject("change app icon error: \(String(describing: error?.localizedDescription))")
                    return
                }
                let msg = isMain ? "Change to Main Icon" : "Change to \(name!) Icon"
                call.resolve([
                    "result": msg
                ])
            }
        }
        
        
    }

}
