package com.michaelflisar.recyclerviewpreferences.settings;

import android.app.Activity;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.michaelflisar.recyclerviewpreferences.R;
import com.michaelflisar.recyclerviewpreferences.base.BaseSetting;
import com.michaelflisar.recyclerviewpreferences.base.SettingsText;
import com.michaelflisar.recyclerviewpreferences.fastadapter.settings.BaseSettingsItem;
import com.michaelflisar.recyclerviewpreferences.fastadapter.settings.EditTextSettingItem;
import com.michaelflisar.recyclerviewpreferences.interfaces.ISettCallback;
import com.michaelflisar.recyclerviewpreferences.interfaces.ISettData;
import com.michaelflisar.recyclerviewpreferences.interfaces.ISettingsViewHolder;
import com.mikepenz.fastadapter.IExpandable;
import com.mikepenz.fastadapter.IItem;
import com.mikepenz.iconics.typeface.IIcon;

/**
 * Created by flisar on 16.05.2017.
 */

public class TextSetting<
        CLASS,
        SettData extends ISettData<String, CLASS, SettData, VH>,
        VH extends RecyclerView.ViewHolder & ISettingsViewHolder<String, CLASS, SettData, VH>>
        extends BaseSetting<String, CLASS, SettData, VH> {

    public TextSetting(Class<CLASS> clazz, SettData settData, int title, IIcon icon) {
        this(clazz, settData, new SettingsText(title), icon);
    }

    public TextSetting(Class<CLASS> clazz, SettData settData, String title, IIcon icon) {
        this(clazz, settData, new SettingsText(title), icon);
    }

    private TextSetting(Class<CLASS> clazz, SettData settData, SettingsText title, IIcon icon) {
        super(clazz, settData, title, icon);
    }

    @Override
    public void updateValueView(boolean topView, VH vh, View v, SettData settData, boolean global, ISettCallback callback) {
        String text = getValue((CLASS)callback.getCustomSettingsObject(), global);
        ((TextView) v).setText(text);
    }

    @Override
    public void bind(VH vh) {
    }

    @Override
    public void unbind(VH vh) {
    }

    @Override
    public void onShowChangeSetting(VH vh, Activity activity, ViewDataBinding binding, SettData settData, boolean global, CLASS customSettingsObject) {
        // nichts zu tun, EditText geht direkt
    }

    @Override
    public final int getLayoutTypeId() {
        return R.id.id_adapter_setting_edittext_item;
    }

    @Override
    public final int getLayout() {
        return R.layout.adapter_base_setting_item;
    }

    @Override
    public <P extends IItem & IExpandable> BaseSettingsItem<P, String, CLASS, SettData, ?> createItem(boolean global, boolean compact, ISettCallback settingsCallback, boolean flatStyle) {
        return new EditTextSettingItem(global, compact, this, settingsCallback, flatStyle);
    }
}
