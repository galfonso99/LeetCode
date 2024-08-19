package main
 func restoreArray(pairs [] []int) []int {
   result := []int{}
   mapping := [100001][]int{}
   // hashmap := make(map([int][]int))

   for i := 0; i < len(pairs); i++ {
     pair := pairs[i]
     append(mapping[pair[0]], pair[1]) 
     append(mapping[pair[1]], pair[0]) 


   }
   for i := 0; i < len()

   
   return result
 }


 /*
 * map int to []int
 * pass the map until you find an element with only 1 pair thats the start
 * then the second element is the only pair of the first array
 * then the third element is the one adjacent to the second element that hasnt been visited yet
 * And so on and so on
 */
