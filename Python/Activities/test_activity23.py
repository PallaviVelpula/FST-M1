import pytest


# def num_list():
#
#     numList = [0,1,2,3,4,5,6,7,8,9,10]
#     return numList

def test_fixtureTest(num_list):
    # numList = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    numSum = 0
    for num in num_list:
        numSum = numSum + num

    assert numSum == 55
