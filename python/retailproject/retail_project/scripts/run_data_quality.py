from dq.run_gx_checks import run_data_quality


if __name__ == "__main__":

    success = run_data_quality()

    if not success:
        raise SystemExit(1)
