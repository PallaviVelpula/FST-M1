import pytest


def test_sumOfNumbers():
    assert 2 + 3 == 5


def test_diffOfNumbers():
    assert 9 - 7 == 2


@pytest.mark.activity
def test_productOfNumbers():
    assert 4 * 6 == 24


@pytest.mark.activity
def test_QuotientOfNumbers():
    assert 8 / 2 == 4
