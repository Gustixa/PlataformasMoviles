package com.samuel.lab_10.ui.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0013\u0014B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/samuel/lab_10/ui/adapters/CharacterAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/samuel/lab_10/ui/adapters/CharacterAdapter$ViewHolder;", "dataSet", "", "Lcom/samuel/lab_10/dataSource/local/model/Character;", "listener", "Lcom/samuel/lab_10/ui/adapters/CharacterAdapter$RecyclerViewCharactersEvents;", "(Ljava/util/List;Lcom/samuel/lab_10/ui/adapters/CharacterAdapter$RecyclerViewCharactersEvents;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "RecyclerViewCharactersEvents", "ViewHolder", "app_release"})
public final class CharacterAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.samuel.lab_10.ui.adapters.CharacterAdapter.ViewHolder> {
    private final java.util.List<com.samuel.lab_10.dataSource.local.model.Character> dataSet = null;
    private final com.samuel.lab_10.ui.adapters.CharacterAdapter.RecyclerViewCharactersEvents listener = null;
    
    public CharacterAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.samuel.lab_10.dataSource.local.model.Character> dataSet, @org.jetbrains.annotations.NotNull()
    com.samuel.lab_10.ui.adapters.CharacterAdapter.RecyclerViewCharactersEvents listener) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.samuel.lab_10.ui.adapters.CharacterAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.samuel.lab_10.ui.adapters.CharacterAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/samuel/lab_10/ui/adapters/CharacterAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "listener", "Lcom/samuel/lab_10/ui/adapters/CharacterAdapter$RecyclerViewCharactersEvents;", "(Landroid/view/View;Lcom/samuel/lab_10/ui/adapters/CharacterAdapter$RecyclerViewCharactersEvents;)V", "imageCharacter", "Landroid/widget/ImageView;", "layoutCharacter", "Landroidx/constraintlayout/widget/ConstraintLayout;", "textName", "Landroid/widget/TextView;", "textSpecies", "textStatus", "setData", "", "character", "Lcom/samuel/lab_10/dataSource/local/model/Character;", "app_release"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final android.view.View view = null;
        private final com.samuel.lab_10.ui.adapters.CharacterAdapter.RecyclerViewCharactersEvents listener = null;
        private final androidx.constraintlayout.widget.ConstraintLayout layoutCharacter = null;
        private final android.widget.ImageView imageCharacter = null;
        private final android.widget.TextView textName = null;
        private final android.widget.TextView textSpecies = null;
        private final android.widget.TextView textStatus = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view, @org.jetbrains.annotations.NotNull()
        com.samuel.lab_10.ui.adapters.CharacterAdapter.RecyclerViewCharactersEvents listener) {
            super(null);
        }
        
        public final void setData(@org.jetbrains.annotations.NotNull()
        com.samuel.lab_10.dataSource.local.model.Character character) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/samuel/lab_10/ui/adapters/CharacterAdapter$RecyclerViewCharactersEvents;", "", "onItemClicked", "", "character", "Lcom/samuel/lab_10/dataSource/local/model/Character;", "app_release"})
    public static abstract interface RecyclerViewCharactersEvents {
        
        public abstract void onItemClicked(@org.jetbrains.annotations.NotNull()
        com.samuel.lab_10.dataSource.local.model.Character character);
    }
}