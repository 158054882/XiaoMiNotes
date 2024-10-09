/*
 * Copyright (c) 2010-2011, The MiCode Open Source Community (www.micode.net)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.micode.notes.tool;

import android.content.Context;
import android.preference.PreferenceManager;

import net.micode.notes.R;
import net.micode.notes.ui.NotesPreferenceActivity;

public class ResourceParser {

    public static final int YELLOW           = 0;
    public static final int BLUE             = 1;
    public static final int WHITE            = 2;
    public static final int GREEN            = 3;
    public static final int RED              = 4;

    public static final int BG_DEFAULT_COLOR = YELLOW;

    public static final int TEXT_SMALL       = 0;
    public static final int TEXT_MEDIUM      = 1;
    public static final int TEXT_LARGE       = 2;
    public static final int TEXT_SUPER       = 3;

    public static final int BG_DEFAULT_FONT_SIZE = TEXT_MEDIUM;

    public static class NoteBgResources {
        private final static int [] BG_EDIT_RESOURCES = new int [] {
            R.drawable.edit_yellow,
            R.drawable.edit_blue,
            R.drawable.edit_white,
            R.drawable.edit_green,
            R.drawable.edit_red
        };

        private final static int [] BG_EDIT_TITLE_RESOURCES = new int [] {
            R.drawable.edit_title_yellow,
            R.drawable.edit_title_blue,
            R.drawable.edit_title_white,
            R.drawable.edit_title_green,
            R.drawable.edit_title_red
        };

        public static int getNoteBgResource(int id) {
            return BG_EDIT_RESOURCES[id];
        }

        public static int getNoteTitleBgResource(int id) {
            return BG_EDIT_TITLE_RESOURCES[id];
        }
    }

    public static int getDefaultBgId(Context context) {
        if (PreferenceManager.getDefaultSharedPreferences(context).getBoolean(
                NotesPreferenceActivity.PREFERENCE_SET_BG_COLOR_KEY, false)) {
            return (int) (Math.random() * NoteBgResources.BG_EDIT_RESOURCES.length);
        } else {
            return BG_DEFAULT_COLOR;
        }
    }

    public static class NoteItemBgResources {
        private final static int [] BG_FIRST_RESOURCES = new int [] {
            R.drawable.list_yellow_up,
            R.drawable.list_blue_up,
            R.drawable.list_white_up,
            R.drawable.list_green_up,
            R.drawable.list_red_up
        };

        private final static int [] BG_NORMAL_RESOURCES = new int [] {
            R.drawable.list_yellow_middle,
            R.drawable.list_blue_middle,
            R.drawable.list_white_middle,
            R.drawable.list_green_middle,
            R.drawable.list_red_middle
        };

        private final static int [] BG_LAST_RESOURCES = new int [] {
            R.drawable.list_yellow_down,
            R.drawable.list_blue_down,
            R.drawable.list_white_down,
            R.drawable.list_green_down,
            R.drawable.list_red_down,
        };

        private final static int [] BG_SINGLE_RESOURCES = new int [] {
            R.drawable.list_yellow_single,
            R.drawable.list_blue_single,
            R.drawable.list_white_single,
            R.drawable.list_green_single,
            R.drawable.list_red_single
        };

        public static int getNoteBgFirstRes(int id) {
            return BG_FIRST_RESOURCES[id];
        }

        public static int getNoteBgLastRes(int id) {
            return BG_LAST_RESOURCES[id];
        }

        public static int getNoteBgSingleRes(int id) {
            return BG_SINGLE_RESOURCES[id];
        }

        public static int getNoteBgNormalRes(int id) {
            return BG_NORMAL_RESOURCES[id];
        }

        public static int getFolderBgRes() {
            return R.drawable.list_folder;
        }
    }

    public static class WidgetBgResources {
        private final static int [] BG_2X_RESOURCES = new int [] {
            R.drawable.widget_2x_yellow,
            R.drawable.widget_2x_blue,
            R.drawable.widget_2x_white,
            R.drawable.widget_2x_green,
            R.drawable.widget_2x_red,
        };

        public static int getWidget2xBgResource(int id) {
            return BG_2X_RESOURCES[id];
        }

        private final static int [] BG_4X_RESOURCES = new int [] {
            R.drawable.widget_4x_yellow,
            R.drawable.widget_4x_blue,
            R.drawable.widget_4x_white,
            R.drawable.widget_4x_green,
            R.drawable.widget_4x_red
        };

        public static int getWidget4xBgResource(int id) {
            return BG_4X_RESOURCES[id];
        }
    }

    public static class TextAppearanceResources {
        private final static int [] TEXTAPPEARANCE_RESOURCES = new int [] {
            R.style.TextAppearanceNormal,
            R.style.TextAppearanceMedium,
            R.style.TextAppearanceLarge,
            R.style.TextAppearanceSuper
        };

        public static int getTexAppearanceResource(int id) {
            /**
             * HACKME: Fix bug of store the resource id in shared preference.
             * The id may larger than the length of resources, in this case,
             * return the {@link ResourceParser#BG_DEFAULT_FONT_SIZE}
             */
            if (id >= TEXTAPPEARANCE_RESOURCES.length) {
                return BG_DEFAULT_FONT_SIZE;
            }
            return TEXTAPPEARANCE_RESOURCES[id];
        }

        public static int getResourcesSize() {
            return TEXTAPPEARANCE_RESOURCES.length;
        }
    }

 /*
代码说明
主题常量定义：定义了三种主题（亮色、暗色、多彩）。
主题颜色数组：使用二维数组存储每个主题的主色和强调色。
获取当前主题颜色的方法：
getCurrentPrimaryColor：返回当前主题的主色。
getCurrentAccentColor：返回当前主题的强调色。
设置和获取当前主题：
setCurrentTheme：允许外部设置当前主题。
getCurrentTheme：返回当前主题。
动态更新主题：
applyTheme：在活动中应用当前主题。
使用示例
在你的 Activity 中，可以在 onCreate 方法中调用 ResourceParser.applyTheme(this); 来应用主题。

这样，你就为 ResourceParser 增加了主题颜色支持的功能，提升了应用的可定制性和用户体验。
*/
    //新增功能：主题颜色支持。这段代码实现了主题颜色的定义和获取，同时允许动态更新应用的主题颜色。
    public static final int THEME_LIGHT = 0;
    public static final int THEME_DARK = 1;
    public static final int THEME_COLORFUL = 2;

    private static int currentTheme = THEME_LIGHT; // 默认主题

    // 主题颜色资源定义
    private static final int[][] THEME_COLORS = {
        { R.color.light_primary, R.color.light_accent },  // 主题：亮色
        { R.color.dark_primary, R.color.dark_accent },    // 主题：暗色
        { R.color.colorful_primary, R.color.colorful_accent } // 主题：多彩
    };

    // 获取当前主题颜色的主色
    public static int getCurrentPrimaryColor(Context context) {
        return context.getResources().getColor(THEME_COLORS[currentTheme][0]);
    }

    // 获取当前主题颜色的强调色
    public static int getCurrentAccentColor(Context context) {
        return context.getResources().getColor(THEME_COLORS[currentTheme][1]);
    }

    // 设置主题颜色
    public static void setCurrentTheme(int theme) {
        if (theme >= 0 && theme < THEME_COLORS.length) {
            currentTheme = theme;
        }
    }

    // 获取当前主题
    public static int getCurrentTheme() {
        return currentTheme;
    }

    // 动态更新主题颜色（可用于Activity或Fragment）
    public static void applyTheme(Activity activity) {
        switch (currentTheme) {
            case THEME_LIGHT:
                activity.setTheme(R.style.Theme_Light);
                break;
            case THEME_DARK:
                activity.setTheme(R.style.Theme_Dark);
                break;
            case THEME_COLORFUL:
                activity.setTheme(R.style.Theme_Colorful);
                break;
        }
    }
}
