# D(X) = E[(X-EX)^2] = E(X^2) - (EX)^2
# Here the formulas are used for the overall variance

from typing import List 
# 1. use Numpy
def get_VarWithnp(nums:List[int]) -> float:
    import numpy as np
    return np.var(nums)


# 2. Don't use other lib

def get_Var(nums:List[int]) -> float:
    nums_mean = sum(nums)/len(nums)
    return sum([(num-nums_mean)**2 for num in nums]) / len(nums)


# Compare

print("(use)The var of nums is %.5f"%get_VarWithnp([1,2,3,4,5,6]))
print("(no)The var of nums is %.5f"%get_Var([1,2,3,4,5,6]))

