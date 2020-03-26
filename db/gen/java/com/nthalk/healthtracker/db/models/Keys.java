/*
 * This file is generated by jOOQ.
 */
package com.nthalk.healthtracker.db.models;


import com.nthalk.healthtracker.db.models.tables.FlywaySchemaHistory;
import com.nthalk.healthtracker.db.models.tables.User;
import com.nthalk.healthtracker.db.models.tables.UserCheckin;
import com.nthalk.healthtracker.db.models.tables.UserToken;
import com.nthalk.healthtracker.db.models.tables.records.FlywaySchemaHistoryRecord;
import com.nthalk.healthtracker.db.models.tables.records.UserCheckinRecord;
import com.nthalk.healthtracker.db.models.tables.records.UserRecord;
import com.nthalk.healthtracker.db.models.tables.records.UserTokenRecord;

import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code></code> schema.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<UserRecord, Long> IDENTITY_USER = Identities0.IDENTITY_USER;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<FlywaySchemaHistoryRecord> FLYWAY_SCHEMA_HISTORY_PK = UniqueKeys0.FLYWAY_SCHEMA_HISTORY_PK;
    public static final UniqueKey<UserRecord> USER_PKEY = UniqueKeys0.USER_PKEY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<UserCheckinRecord, UserRecord> USER_CHECKIN__USER_CHECKIN_USER_ID_FKEY = ForeignKeys0.USER_CHECKIN__USER_CHECKIN_USER_ID_FKEY;
    public static final ForeignKey<UserTokenRecord, UserRecord> USER_TOKEN__USER_TOKEN_USER_ID_FKEY = ForeignKeys0.USER_TOKEN__USER_TOKEN_USER_ID_FKEY;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 {
        public static Identity<UserRecord, Long> IDENTITY_USER = Internal.createIdentity(User.USER, User.USER.USER_ID);
    }

    private static class UniqueKeys0 {
        public static final UniqueKey<FlywaySchemaHistoryRecord> FLYWAY_SCHEMA_HISTORY_PK = Internal.createUniqueKey(FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY, "flyway_schema_history_pk", new TableField[] { FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.INSTALLED_RANK }, true);
        public static final UniqueKey<UserRecord> USER_PKEY = Internal.createUniqueKey(User.USER, "USER_pkey", new TableField[] { User.USER.USER_ID }, true);
    }

    private static class ForeignKeys0 {
        public static final ForeignKey<UserCheckinRecord, UserRecord> USER_CHECKIN__USER_CHECKIN_USER_ID_FKEY = Internal.createForeignKey(Keys.USER_PKEY, UserCheckin.USER_CHECKIN, "user_checkin_user_id_fkey", new TableField[] { UserCheckin.USER_CHECKIN.USER_ID }, true);
        public static final ForeignKey<UserTokenRecord, UserRecord> USER_TOKEN__USER_TOKEN_USER_ID_FKEY = Internal.createForeignKey(Keys.USER_PKEY, UserToken.USER_TOKEN, "user_token_user_id_fkey", new TableField[] { UserToken.USER_TOKEN.USER_ID }, true);
    }
}