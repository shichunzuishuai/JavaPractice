var app = new Vue({
    el: '.center',
    data: {
        // 当前登录用户的用户名, 为空字符串表示未登录状态
        name: "",

        // 当前的菜品列表
        dishes: [
            // {
            //     dishId: 1,
            //     name: '京酱肉丝',
            //     price: 2000,
            //     isSelected: null,
            // },
            // {
            //     dishId: 2,
            //     name: '宫保鸡丁',
            //     price: 1800,
            //     isSelected: null,
            // },
            // {
            //     dishId: 3,
            //     name: '红烧肉',
            //     price: 2500,
            //     isSelected: null,
            // },
        ],
    },
    methods: {
        // 判定当前是否登录
        isLogin() {
            if (this.name == "") {
                return false;
            }
            return true;
        },
        // 从服务器检测登录状态
        checkLogin() {
            // 页面最初加载时先访问服务器判定自身的登陆状态.
            console.log("checkLogin");
            $.ajax({
                url: 'login',
                type: 'get',
                success: function (data, status) {
                    if (data.ok != 1) {
                        return;
                    }
                    // 登录成功后
                    // 1. 设置用户名
                    app.name = data.name;
                    // 2. 获取菜品列表
                    app.getDishes();
                }
            });
        },
        // 获取菜品信息
        getDishes() {
            // 获取菜品信息
            console.log("getDishes");
            $.ajax({
                url: 'dish',
                type: 'get',
                success: function (data, status) {
                    app.dishes = data;
                }
            })
        },
        postOrder() {
            console.log("postOrder");
            dishIds = [];
            app.dishes.forEach(dish => {
                if (dish.isSelected) {
                    dishIds.push(dish.dishId);
                }
            });
            $.ajax({
                url: 'order',
                type: 'post',
                data: JSON.stringify(dishIds),
                success: function (data, status) {
                    if (data.ok != 1) {
                        alert("下单失败! " + data.reason);
                        return;
                    }
                    alert("下单成功!");
                    // 下单成功, 跳转到 user-order.html 页面
                    window.location.href = "user-order.html";
                },
            });
        },
        logout() {
            alert("注销功能还未实现嗷! 少年我看你骨骼清奇, 是编程奇才, 要不自己试试?");
        }
    },
    computed: {
        selectedDishCount() {
            let count = 0;
            this.dishes.forEach(dish => {
                if (dish.isSelected) {
                    count++;
                }
            });
            return count;
        },
        selectedDishPrice() {
            let price = 0;
            this.dishes.forEach(dish => {
                if (dish.isSelected) {
                    price += dish.price;
                }
            })
            return price / 100;
        }
    }
});