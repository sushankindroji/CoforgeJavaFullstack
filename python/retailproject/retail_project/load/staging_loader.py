def load_to_staging(df, staging_table, engine):
    df.to_sql(
        staging_table,
        engine,
        if_exists="append",
        index=False,
        method="multi",
    )
