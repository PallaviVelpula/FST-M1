import pytest


@pytest.fixture
def input_value():
    return 10


@pytest.fixture
def num_list():
    numList = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    return numList

@pytest.fixture
def wallet():
    amount =0
    return amount
