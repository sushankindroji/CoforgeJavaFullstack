from pathlib import Path

def write_delta(df, path, mode="overwrite"):
    Path(path).parent.mkdir(parents=True, exist_ok=True)
    (df.write.format("delta").mode(mode)
       .option("overwriteSchema","true").save(path))

def write_layer(base_dir, layer, datasets):
    for name, df in datasets.items():
        write_delta(df, str(Path(base_dir)/layer/name))
