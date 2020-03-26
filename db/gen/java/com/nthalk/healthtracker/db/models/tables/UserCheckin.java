/*
 * This file is generated by jOOQ.
 */
package com.nthalk.healthtracker.db.models.tables;


import com.nthalk.healthtracker.db.models.DefaultSchema;
import com.nthalk.healthtracker.db.models.Keys;
import com.nthalk.healthtracker.db.models.tables.records.UserCheckinRecord;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row11;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserCheckin extends TableImpl<UserCheckinRecord> {

    private static final long serialVersionUID = 1750927001;

    /**
     * The reference instance of <code>user_checkin</code>
     */
    public static final UserCheckin USER_CHECKIN = new UserCheckin();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UserCheckinRecord> getRecordType() {
        return UserCheckinRecord.class;
    }

    /**
     * The column <code>user_checkin.user_id</code>.
     */
    public final TableField<UserCheckinRecord, Long> USER_ID = createField(DSL.name("user_id"), org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>user_checkin.created_at</code>.
     */
    public final TableField<UserCheckinRecord, OffsetDateTime> CREATED_AT = createField(DSL.name("created_at"), org.jooq.impl.SQLDataType.TIMESTAMPWITHTIMEZONE.nullable(false), this, "");

    /**
     * The column <code>user_checkin.gps_latitude</code>.
     */
    public final TableField<UserCheckinRecord, Double> GPS_LATITUDE = createField(DSL.name("gps_latitude"), org.jooq.impl.SQLDataType.DOUBLE.nullable(false), this, "");

    /**
     * The column <code>user_checkin.gps_longitude</code>.
     */
    public final TableField<UserCheckinRecord, Double> GPS_LONGITUDE = createField(DSL.name("gps_longitude"), org.jooq.impl.SQLDataType.DOUBLE.nullable(false), this, "");

    /**
     * The column <code>user_checkin.gps_accuracy</code>.
     */
    public final TableField<UserCheckinRecord, Double> GPS_ACCURACY = createField(DSL.name("gps_accuracy"), org.jooq.impl.SQLDataType.DOUBLE.nullable(false), this, "");

    /**
     * The column <code>user_checkin.temperature</code>.
     */
    public final TableField<UserCheckinRecord, Float> TEMPERATURE = createField(DSL.name("temperature"), org.jooq.impl.SQLDataType.REAL.nullable(false), this, "");

    /**
     * The column <code>user_checkin.fever_start_at</code>.
     */
    public final TableField<UserCheckinRecord, OffsetDateTime> FEVER_START_AT = createField(DSL.name("fever_start_at"), org.jooq.impl.SQLDataType.TIMESTAMPWITHTIMEZONE, this, "");

    /**
     * The column <code>user_checkin.sore_throat_scale</code>.
     */
    public final TableField<UserCheckinRecord, Integer> SORE_THROAT_SCALE = createField(DSL.name("sore_throat_scale"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>user_checkin.congestion_scale</code>.
     */
    public final TableField<UserCheckinRecord, Integer> CONGESTION_SCALE = createField(DSL.name("congestion_scale"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>user_checkin.cold_sweats_scale</code>.
     */
    public final TableField<UserCheckinRecord, Integer> COLD_SWEATS_SCALE = createField(DSL.name("cold_sweats_scale"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>user_checkin.sensitive_skin_scale</code>.
     */
    public final TableField<UserCheckinRecord, Integer> SENSITIVE_SKIN_SCALE = createField(DSL.name("sensitive_skin_scale"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * Create a <code>user_checkin</code> table reference
     */
    public UserCheckin() {
        this(DSL.name("user_checkin"), null);
    }

    /**
     * Create an aliased <code>user_checkin</code> table reference
     */
    public UserCheckin(String alias) {
        this(DSL.name(alias), USER_CHECKIN);
    }

    /**
     * Create an aliased <code>user_checkin</code> table reference
     */
    public UserCheckin(Name alias) {
        this(alias, USER_CHECKIN);
    }

    private UserCheckin(Name alias, Table<UserCheckinRecord> aliased) {
        this(alias, aliased, null);
    }

    private UserCheckin(Name alias, Table<UserCheckinRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> UserCheckin(Table<O> child, ForeignKey<O, UserCheckinRecord> key) {
        super(child, key, USER_CHECKIN);
    }

    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public List<ForeignKey<UserCheckinRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<UserCheckinRecord, ?>>asList(Keys.USER_CHECKIN__USER_CHECKIN_USER_ID_FKEY);
    }

    public User user() {
        return new User(this, Keys.USER_CHECKIN__USER_CHECKIN_USER_ID_FKEY);
    }

    @Override
    public UserCheckin as(String alias) {
        return new UserCheckin(DSL.name(alias), this);
    }

    @Override
    public UserCheckin as(Name alias) {
        return new UserCheckin(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public UserCheckin rename(String name) {
        return new UserCheckin(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public UserCheckin rename(Name name) {
        return new UserCheckin(name, null);
    }

    // -------------------------------------------------------------------------
    // Row11 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row11<Long, OffsetDateTime, Double, Double, Double, Float, OffsetDateTime, Integer, Integer, Integer, Integer> fieldsRow() {
        return (Row11) super.fieldsRow();
    }
}
