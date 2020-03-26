/*
 * This file is generated by jOOQ.
 */
package com.nthalk.healthtracker.db.models.tables;


import com.nthalk.healthtracker.db.models.DefaultSchema;
import com.nthalk.healthtracker.db.models.Keys;
import com.nthalk.healthtracker.db.models.tables.records.UserRecord;

import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row3;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class User extends TableImpl<UserRecord> {

    private static final long serialVersionUID = 1884949813;

    /**
     * The reference instance of <code>USER</code>
     */
    public static final User USER = new User();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UserRecord> getRecordType() {
        return UserRecord.class;
    }

    /**
     * The column <code>USER.user_id</code>.
     */
    public final TableField<UserRecord, Long> USER_ID = createField(DSL.name("user_id"), org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('\"USER_user_id_seq\"'::regclass)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>USER.normal_min_temperature</code>.
     */
    public final TableField<UserRecord, Float> NORMAL_MIN_TEMPERATURE = createField(DSL.name("normal_min_temperature"), org.jooq.impl.SQLDataType.REAL, this, "");

    /**
     * The column <code>USER.normal_max_temperature</code>.
     */
    public final TableField<UserRecord, Float> NORMAL_MAX_TEMPERATURE = createField(DSL.name("normal_max_temperature"), org.jooq.impl.SQLDataType.REAL, this, "");

    /**
     * Create a <code>USER</code> table reference
     */
    public User() {
        this(DSL.name("USER"), null);
    }

    /**
     * Create an aliased <code>USER</code> table reference
     */
    public User(String alias) {
        this(DSL.name(alias), USER);
    }

    /**
     * Create an aliased <code>USER</code> table reference
     */
    public User(Name alias) {
        this(alias, USER);
    }

    private User(Name alias, Table<UserRecord> aliased) {
        this(alias, aliased, null);
    }

    private User(Name alias, Table<UserRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> User(Table<O> child, ForeignKey<O, UserRecord> key) {
        super(child, key, USER);
    }

    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public Identity<UserRecord, Long> getIdentity() {
        return Keys.IDENTITY_USER;
    }

    @Override
    public UniqueKey<UserRecord> getPrimaryKey() {
        return Keys.USER_PKEY;
    }

    @Override
    public List<UniqueKey<UserRecord>> getKeys() {
        return Arrays.<UniqueKey<UserRecord>>asList(Keys.USER_PKEY);
    }

    @Override
    public User as(String alias) {
        return new User(DSL.name(alias), this);
    }

    @Override
    public User as(Name alias) {
        return new User(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public User rename(String name) {
        return new User(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public User rename(Name name) {
        return new User(name, null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<Long, Float, Float> fieldsRow() {
        return (Row3) super.fieldsRow();
    }
}
