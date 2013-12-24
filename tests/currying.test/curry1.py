#####################
# curried functions #
#####################
# Move the cursor to curr, curr1, curr2, curr3 to show type hints.
# Like ML or Haskell, the arrow operator is right-associative,
# so you see "int -> int -> int" instead of "int -> (int -> int)"

def curr(x):
  return lambda y: lambda z: x + y + z

curr1 = curr(1)
curr2 = curr1(2)
curr3 = curr2(3)
