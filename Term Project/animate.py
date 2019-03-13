import matplotlib.pyplot as plt
from matplotlib.animation import FuncAnimation

# settings
n = 2
data_file = "position.data"
total_steps = int(1e7//7200)
file = open(data_file, "r")

def update(frame):
    for i in range(2):
        animated_bodies[i].set_data(bodies[i].x[frame], bodies[i].y[frame])
    
    return animated_bodies[0], animated_bodies[1]

class body():
    def __init__(self):
        self.x = []
        self.y = []



# setting up fig and axis
fig, ax = plt.subplots()
ax.set_facecolor('xkcd:black')
ax.set_xlim(-7e11, 7e11)
ax.set_ylim(-7e11, 7e11)

# creating objects to that contains the position data
bodies = []
for i in range(n):
    # adding bodies
    bodies.append(body())

for i in range(total_steps):
    for j in range(n):
        try:
            x = float(file.readline().strip("\n"))
            y = float(file.readline().strip("\n"))
            bodies[j].x.append(x)
            bodies[j].y.append(y)
        except:
            break

# creating aniated objects
animated_bodies = []

for i in range(n):
    new, = plt.plot([],[],color='red',marker='o',markersize=7,animated=True)
    animated_bodies.append(new)
    

ani = FuncAnimation(fig, update, interval=1, blit=True)
plt.show()



