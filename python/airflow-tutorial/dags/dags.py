from datetime import datetime

from airflow import DAG
from airflow.operators.python import PythonOperator


def hello_world_1():
    print("Hello World from Task 1!")


def hello_world_2():
    print("Hello World from Task 2!")


with DAG(
    dag_id="hello_world_two_tasks",
    start_date=datetime(2026, 8, 14),
    schedule=None,
    catchup=False,
    tags=["demo"],
) as dag:

    task_1 = PythonOperator(
        task_id="hello_world_task_1",
        python_callable=hello_world_1,
    )

    task_2 = PythonOperator(
        task_id="hello_world_task_2",
        python_callable=hello_world_2,
    )

    task_1 >> task_2