# pass types as first-class values

class A:
  w = 'foo'

def pass_type(t):
  return t

type1 = pass_type(A)
o1  = type1()

print o1.w  # w should refer to A.w
