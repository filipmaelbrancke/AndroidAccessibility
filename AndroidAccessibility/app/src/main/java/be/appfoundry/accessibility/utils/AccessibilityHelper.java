package be.appfoundry.accessibility.utils;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.view.accessibility.AccessibilityManager;
import java.util.List;


public class AccessibilityHelper {

    private final AccessibilityManager accessibilityManager;

    public static AccessibilityHelper newInstance(final Context context) {
        final AccessibilityManager am = (AccessibilityManager) context.getSystemService(Context.ACCESSIBILITY_SERVICE);
        return new AccessibilityHelper(am);
    }

    public AccessibilityHelper(final AccessibilityManager accessibilityManager) {
        this.accessibilityManager = accessibilityManager;
    }

    public boolean isAccessibilityEnabled() {
        boolean isAccessibilityEnabled = accessibilityManager.isEnabled();
        boolean isExploreByTouchEnabled = accessibilityManager.isTouchExplorationEnabled();
        boolean isSpokenFeedbackEnabled = isSpokenFeedbackEnabled();
        return isAccessibilityEnabled && isExploreByTouchEnabled && isSpokenFeedbackEnabled;
    }

    public boolean isSpokenFeedbackEnabled() {
        List<AccessibilityServiceInfo> enabledServices = accessibilityManager.getEnabledAccessibilityServiceList(AccessibilityServiceInfo.FEEDBACK_SPOKEN);
        return !enabledServices.isEmpty();
    }

}