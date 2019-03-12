1. 所使用的开发环境(Eclipse、NetBeans，JBuilder)。

集成开发环境：eclipse
编码方式 UTF - 8
JDK版本：jdk-8u131-docs-all


2. 论述题目的需求。给出软件功能架构图。

    本程序可通过菜单(JMenu)选择功能查看（V）、编辑（E）、帮助(H)等。计算器囊括科学计算器、IT计算器和关系计算器。通过Swing和awt实现JAVA程序可视化页面。用户可以通过鼠标点击输入相应的运算。科学计算器程序可进行四则运算。而且通过两个链表(LinkedList)，能对输入的算式判断运算符优先级。科学计算器实现的功能有幂运算、对数运算、三角函数、平方根、立方根、求余、阶乘等等。其中三角函数可分别进行角度、弧度、梯度运算。IT计算器可实现二、八、十、十六进制数相互转换，求倒数等功能。关系计算器解决了关系称呼上的问题，基本覆盖了关系血脉上的称呼。
    

3. 论述界面设计过程，指出其设计上的创意及组件的布局策略。

    界面MyFrame为主界面，统筹各个界面。先在MyFrame中设置BorderLayout，把JMenuBar的实例菜单栏mb加载北边，把JPanel的实例cardPanel加载在中间。
    mb上添加JMenu菜单查看（V），编辑（E），帮助（H）。查看中添加JMenuItem菜单项系统时间，科学型，关系型，IT型，退出。编辑中添加JMenu菜单背景和字体。设置中添加JMenuItem菜单项绿色、白色、黄色、青色、粉色和蓝色。字体添加菜单项增大、减小。帮助菜单中添加菜单项使用(U)、关于（A）。帮助菜单项通过注册MenuListen，通过JOptionpane显示帮助信息图。
    主页面的创意之处为cardPanel。其设置为CardLayout布局，依次添加SciencePanel，ITPanel，RelationshipPanel面板。菜单项的计算器类型按钮可切换至相应的计算器类型，从而实现一个软件多个计算器的功能。
    SciencePanel为科学计算器面板。其面板为GridLayout布局，二行一列。第一行的contextPanel设置为BorderLayout布局，带有滚动条的文本域加载在center，角度和时间加载在south。第二行的buttonPanel设置为GridLayout，依次添加各个按钮。该Panel的创意之处为添加了单选按钮弧度、角度、梯度。
    ITPanel添加带滚动条的文本域，单选按钮，数字按钮。该Panel的特点是单选按钮可对数字进行多进制转换，因此命名为程序员(IT)计算器。
    relationshipPanel添加文本域和带中国关系称呼的按钮。该Panel的优势在于通过鼠标点击按钮，通过后台的判断，想文本域显示称呼关系，帮助用户解决称呼问题。
   
