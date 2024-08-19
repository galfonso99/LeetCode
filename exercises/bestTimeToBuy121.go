package main

// import "fmt"

func maxProfit(prices []int) int {
    buyPrice := 100000 
    profit := 0
    for _, price := range prices {
        if (price - buyPrice) > profit {
            profit = price - buyPrice
        }
        if price < buyPrice {
            buyPrice = price
        }
    }
    return profit
}

