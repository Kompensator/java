import pandas as pd
from matplotlib import pyplot as plt
import seaborn as sns
import statistics
import matplotlib.patches as mpatches


dataset = pd.read_csv("iris.data")
variables = ['sepal-length','sepal-width','petal-length','petal-width','class']


print(dataset.describe())
print('\n\n')
print(dataset.corr())

for var in variables[:-1]:
    print("===============================================")
    print(var)
    print("Mean: %r" %(statistics.mean(dataset[var])))
    print("Median: %r" %(statistics.median(dataset[var])))
    print("Stdev: %r" %(statistics.stdev(dataset[var])))


def plot_by_var(var):
    """ for box plot
    """
    fig, ax = plt.subplots(figsize=(6,8))
    axes = dataset.boxplot(column=var, by='TARGET',ax=ax)

    return axes


def scatter_plot(var_x, var_y, color_arr):

    fig = plt.figure(figsize=(8,10))
    ax = fig.add_subplot(111)
    plt.title(var_y + " vs "+var_x)
    plt.xlabel(var_x)
    plt.ylabel(var_y)
    ax.scatter(dataset[var_x], dataset[var_y], c=color_arr)

    setosa = mpatches.Patch(color='#4B0082', label='Iris-setosa')
    versi = mpatches.Patch(color='purple', label='Iris-versicolor')
    virgin = mpatches.Patch(color='#E6E6FA', label='Iris-virginica')

    plt.legend(handles=[setosa, versi, virgin])

    # plt.savefig(var_x + ' vs ' + var_y)
    plt.show()


color = dataset['class']
color_arr = []
for flower in color:
    if flower == "Iris-setosa":
        color_arr.append("#4B0082")
    elif flower == "Iris-versicolor":
        color_arr.append("purple")
    else:
        color_arr.append("#E6E6FA")



# for x in variables:
#     for y in variables:
#         if x != y:
            # scatter_plot(x,y,color_arr)


prediction = []
petal_width = dataset['petal-width']
petal_length = dataset['petal-length']

for i in  range(150):
    if petal_length[i] < 2 and petal_width[i] < 0.75:
        prediction.append("Iris-setosa")
    
    elif petal_length[i] > 2 and petal_length[i] < 5 and petal_width[i] > 0.75 and petal_width[i] < 1.65:
        prediction.append("Iris-versicolor")
    
    else:
        prediction.append("Iris-virginica")

score = 0
for i in range(150):
    print("value " + dataset['class'][i]+ "        prediction "+ prediction[i])
    if dataset['class'][i] == prediction[i]:
        score += 1

print(score)

def plot_prediction():
    color_arr = get_color(dataset)
    var_y = 'petal-width'
    var_x = 'petal-length'
    fig = plt.figure(figsize=(8,10))
    ax = fig.add_subplot(111)
    plt.title("Color prediction")
    plt.xlabel(var_x)
    plt.ylabel(var_y)
    color_arr = []
    for i in range(150):
        if prediction[i] == "Iris-setosa":
            color_arr.append("#4B0082")
        elif prediction[i] == "Iris-versicolor":
            color_arr.append("purple")
        else:
            color_arr.append("#E6E6FA")
    

    ax.scatter(dataset[var_x], dataset[var_y], c=color_arr)

    setosa = mpatches.Patch(color='#4B0082', label='Iris-setosa')
    versi = mpatches.Patch(color='purple', label='Iris-versicolor')
    virgin = mpatches.Patch(color='#E6E6FA', label='Iris-virginica')

    plt.legend(handles=[setosa, versi, virgin])

    # plt.savefig(var_x + ' vs ' + var_y)
    plt.show()
    plt.savefig("prediction")


plot_prediction()