package com.samuel.lab_10.ui.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0012H\u0002J\b\u0010\u0016\u001a\u00020\u0012H\u0002J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\bH\u0016J\b\u0010\u0019\u001a\u00020\u0012H\u0016J\b\u0010\u001a\u001a\u00020\u0012H\u0016J\u001a\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001e\u0010 \u001a\u00020\u00122\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\"0!2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010#\u001a\u00020\u0012H\u0002J\b\u0010$\u001a\u00020\u0012H\u0002J\b\u0010%\u001a\u00020\u0012H\u0002J\u001e\u0010&\u001a\u00020\u00122\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0!2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\'"}, d2 = {"Lcom/samuel/lab_10/ui/fragments/CharacterListFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/samuel/lab_10/ui/adapters/CharacterAdapter$RecyclerViewCharactersEvents;", "()V", "adapter", "Lcom/samuel/lab_10/ui/adapters/CharacterAdapter;", "characters", "", "Lcom/samuel/lab_10/dataSource/local/model/Character;", "database", "Lcom/samuel/lab_10/dataSource/local/DataBase;", "progressBar", "Landroid/widget/ProgressBar;", "recyclerCharacters", "Landroidx/recyclerview/widget/RecyclerView;", "toolbar", "Lcom/google/android/material/appbar/MaterialToolbar;", "fetchCharacters", "", "isSync", "", "getCharacters", "logout", "onItemClicked", "character", "onResume", "onStart", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "saveCharactersLocally", "", "Lcom/samuel/lab_10/dataSource/model/CharacterData;", "setListeners", "setToolbar", "setupRecycler", "showCharacters", "app_debug"})
public final class CharacterListFragment extends androidx.fragment.app.Fragment implements com.samuel.lab_10.ui.adapters.CharacterAdapter.RecyclerViewCharactersEvents {
    private com.samuel.lab_10.ui.adapters.CharacterAdapter adapter;
    private com.google.android.material.appbar.MaterialToolbar toolbar;
    private androidx.recyclerview.widget.RecyclerView recyclerCharacters;
    private android.widget.ProgressBar progressBar;
    private com.samuel.lab_10.dataSource.local.DataBase database;
    private final java.util.List<com.samuel.lab_10.dataSource.local.model.Character> characters = null;
    
    public CharacterListFragment() {
        super();
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onStart() {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    private final void setToolbar() {
    }
    
    private final void setListeners() {
    }
    
    private final void getCharacters() {
    }
    
    private final void fetchCharacters(boolean isSync) {
    }
    
    private final void showCharacters(java.util.List<com.samuel.lab_10.dataSource.local.model.Character> characters, boolean isSync) {
    }
    
    private final void setupRecycler() {
    }
    
    private final void saveCharactersLocally(java.util.List<com.samuel.lab_10.dataSource.model.CharacterData> characters, boolean isSync) {
    }
    
    private final void logout() {
    }
    
    @java.lang.Override()
    public void onItemClicked(@org.jetbrains.annotations.NotNull()
    com.samuel.lab_10.dataSource.local.model.Character character) {
    }
}