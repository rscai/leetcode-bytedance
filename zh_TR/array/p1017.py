import matplotlib.pyplot as plt

l = [0,1,2,4,5,6,7]
plt.plot(l)
plt.plot([0,3,6], [0,4,7],'ro', markersize=12)
plt.annotate('S', xy=(0,0),xytext=(0,l[0]+1))
plt.annotate('M', xy=(3,4),xytext=(3,l[3]+1))
plt.annotate('E', xy=(6,7),xytext=(6,l[6]+1))
plt.axis([-1,7,-1,10])
plt.show()

l = [6,7,0,1,2,4,5]
plt.plot(l)
plt.plot([0,3,6], [6,1,5],'ro', markersize=12)
plt.annotate('S', xy=(0,6),xytext=(0,l[0]+1))
plt.annotate('M', xy=(3,1),xytext=(3,l[3]+1))
plt.annotate('E', xy=(6,5),xytext=(6,l[6]+1))
plt.axis([-1,7,-1,10])
plt.show()

l = [2,4,5,6,7,0,1]
plt.plot(l)
plt.plot([0,3,6], [2,6,1],'ro', markersize=12)
plt.annotate('S', xy=(0,2),xytext=(0,l[0]+1))
plt.annotate('M', xy=(3,6),xytext=(3,l[3]+1))
plt.annotate('E', xy=(6,1),xytext=(6,l[6]+1))
plt.axis([-1,7,-1,10])
plt.show()
