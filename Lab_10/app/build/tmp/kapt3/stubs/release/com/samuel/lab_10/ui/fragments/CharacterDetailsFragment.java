package com.samuel.lab_10.ui.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0002J\b\u0010\u001d\u001a\u00020\u001bH\u0002J\u001a\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020\u001bH\u0002J\b\u0010$\u001a\u00020\u001bH\u0002J\b\u0010%\u001a\u00020\u001bH\u0002J\u0010\u0010&\u001a\u00020\u001b2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\'"}, d2 = {"Lcom/samuel/lab_10/ui/fragments/CharacterDetailsFragment;", "Landroidx/fragment/app/Fragment;", "()V", "args", "Lcom/samuel/lab_10/ui/fragments/CharacterDetailsFragmentArgs;", "getArgs", "()Lcom/samuel/lab_10/ui/fragments/CharacterDetailsFragmentArgs;", "args$delegate", "Landroidx/navigation/NavArgsLazy;", "btnUpdate", "Landroid/widget/Button;", "character", "Lcom/samuel/lab_10/dataSource/local/model/Character;", "database", "Lcom/samuel/lab_10/dataSource/local/DataBase;", "imageCharacter", "Landroid/widget/ImageView;", "toolbar", "Lcom/google/android/material/appbar/MaterialToolbar;", "txtEpisodes", "Lcom/google/android/material/textfield/TextInputLayout;", "txtGender", "txtName", "txtOrigin", "txtSpecies", "txtStatus", "deleteCharacter", "", "fetchCharacter", "getCharacter", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setData", "setListeners", "setToolbar", "updateCharacter", "app_release"})
public final class CharacterDetailsFragment extends androidx.fragment.app.Fragment {
    private final androidx.navigation.NavArgsLazy args$delegate = null;
    private com.google.android.material.textfield.TextInputLayout txtName;
    private com.google.android.material.textfield.TextInputLayout txtSpecies;
    private com.google.android.material.textfield.TextInputLayout txtGender;
    private com.google.android.material.textfield.TextInputLayout txtStatus;
    private com.google.android.material.textfield.TextInputLayout txtOrigin;
    private com.google.android.material.textfield.TextInputLayout txtEpisodes;
    private android.widget.ImageView imageCharacter;
    private com.google.android.material.appbar.MaterialToolbar toolbar;
    private android.widget.Button btnUpdate;
    private com.samuel.lab_10.dataSource.local.DataBase database;
    private com.samuel.lab_10.dataSource.local.model.Character character;
    
    public CharacterDetailsFragment() {
        super();
    }
    
    private final com.samuel.lab_10.ui.fragments.CharacterDetailsFragmentArgs getArgs() {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setToolbar() {
    }
    
    private final void setListeners() {
    }
    
    private final void getCharacter() {
    }
    
    private final void fetchCharacter() {
    }
    
    private final void updateCharacter(com.samuel.lab_10.dataSource.local.model.Character character) {
    }
    
    private final void deleteCharacter() {
    }
    
    private final void setData() {
    }
}