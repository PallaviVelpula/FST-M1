import pytest


@pytest.mark.parametrize("earned_amount, spent_amount, expected_amount", [(30, 10, 20), (20, 2, 18)])
def test_transactions(wallet, earned_amount, spent_amount, expected_amount):
    wallet = wallet + earned_amount
    wallet = wallet - spent_amount

    assert wallet == expected_amount
