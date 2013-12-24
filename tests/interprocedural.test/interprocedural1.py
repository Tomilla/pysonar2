# inter-procedual analysis test

class A1:
  z = 1

class B1:
  z = A1()

class C1:
  z = B1()

o1 = C1()

def f1(x):
  return x.z   # Moving the cursor to 'z' will highlight the z inside class C1 only ...

f1(o1)         # ... because f1 tries to access the 'z' field of o1 (type C1) only

def g1(x):
  return x.z   # Moving the cursor to 'z' will highlight the z inside B1 and C1 ...

g1(g1(o1))     # ... because g1 accesses C1.z which is a B1, then g1 accesses B1.z which is A1

def h1(x):
  return x.z   # Moving the cursor to 'z' will highlight the z inside A1, B1, C1 ...

h1(h1(h1(o1))) # ... bacause h1 accesses C1.z which is a B1, then followed by B1.z, A1.z
