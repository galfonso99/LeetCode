class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
		int total_net_count = 0;
        int local_net_count = 0;
		int starting_station = 0;

		for (int i = 0; i < cost.length; i++) {
            int curr_net_value = gas[i] - cost[i];
			total_net_count += curr_net_value;
            local_net_count += curr_net_value;

            if ( local_net_count < 0 ) {
                local_net_count = 0;
                starting_station = i+1;
            }
		}
		return total_net_count >= 0 ? starting_station : -1;
    }
}


// The idea is to keep 2 calculations whether the whole circuit is completable, and
// which gas station is best suited to be the start
// We keep a running count of the net value of gas - cost, and if by the end it is 0 or positive
// Then we know it is completable
// Simultaneously, we keep a max net value and the gas station with the max will be the resulting 
// gas station unless the circuit cannot be completed, then just return -1
// EDIT TO ADD: Forgot to account for starting_stations that become invalid half-way
// so you need to keep a local running count starting at the curr station and if it dips
// below zero then move unto the next station and reset local running count


