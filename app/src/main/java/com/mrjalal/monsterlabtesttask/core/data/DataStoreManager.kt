package com.mrjalal.monsterlabtesttask.core.data

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext

private val Context.dataStore by preferencesDataStore("MonsterLab")


class DataStoreManager(
    @ApplicationContext private val appContext: Context
) {

    private val dataStore = appContext.dataStore

    companion object {
        private val TOKEN_KEY = stringPreferencesKey("token_key")
    }

    suspend fun saveToken(token: String) {
        dataStore.edit { preferences -> preferences[TOKEN_KEY] = token }
    }
}
