package main

import "fmt"

func groupAnagrams (strs []string) [][]string {
    Map := make(map[[26]byte][]string)
    var result = [][]string{}

    for _, word := range strs {
        arrayMap := [26]byte{}
        for _, char := range word {
            index := char - 'a'
            arrayMap[index] += 1 
        }
        Map[arrayMap] = append(Map[arrayMap], word)
    }
    for _, strings := range Map {
        result = append(result, strings)
    }
    return result
}
// Solution from the internet
// func groupAnagrams(strs []string) [][]string {
// 	mp := map[[26]int][]string{}
// 	for _, s := range strs {
// 		k := [26]int{}
// 		for i := 0; i < len(s); i++ {
// 			k[s[i]-'a'] += 1
// 		}
// 		mp[k] = append(mp[k], s)
// 	}
// 	res := [][]string{}
// 	for _, v := range mp {
// 		res = append(res, v)
// 	}
// 	return res
// }

func main() {
    strs := []string{"eat","tea","tan","ate","nat","bat"}
    res := groupAnagrams(strs)
    fmt.Printf("%q\n", res)
}

// For each word
//      * Create an arrayMap from the chars of the word
//      * Using the arrayMap as the key and the string as the value append 
//              the string to the array that is mapped by the arrayMap 
// After...
// For each value of the HashMap (in this case arrays of string) append them
//       to the array of arrays that will be the return value
