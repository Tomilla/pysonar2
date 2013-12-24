# pass types as first-class values in two branches

class A:
  w = 'foo'

class B:
  w = 42

class C:
  w = 'not me!'


# foo returns either class A or B
def choose_type(x):
  if (x < 100):
    return A
  else:
    return B

type1 = choose_type(random())
o1  = type1()

print o1.w  # w should refer to both A.w and B.w, but not C.w
