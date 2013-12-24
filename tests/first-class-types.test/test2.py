# pass types as first-class values in a field

class A:
  w = 'foo'


class B:
  pass


# get a field named typ
def get_type(x):
  return x.typ


o1 = B()
o1.typ = A

type1 = get_type(o1)
o2  = type1()

print o2.w  # w should refer to A.w
