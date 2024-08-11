int pivotInteger(int x) {
    if (x == 1) {return 1;}
    int arr[x];
    arr[0] = arr[x-1] = 0;
    for (int i = 0; i < x; i++) {
        int prev = i == 0 ? i : i - 1;
        int j = x - i - 1;
        int val_already_on_index = arr[i]; 
        if (i < j) { arr[j] = arr[x - prev - 1] + j + 1;}
        arr[i] = arr[prev] + i + 1;
        if (arr[i] == val_already_on_index && j < i) {
            return i + 1;
        }
    }
    return -1;
}

/* Best optimal solution (Not mine) */
int pivotInteger(int n){
    for(int i=1;i<=n;i++){
        if(i*i == (n*(n+1))/2)
        return i;
    }
    return -1;
}