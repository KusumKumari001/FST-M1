package activities;

public class Activity4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {45,12,10,52,5};
		System.out.println("Unsorted Array : ");
		for(int i =0; i<arr.length ; i++)
		{
			System.out.println(+arr[i]);
		}
		for(int i =0; i<arr.length-1 ; i++)
		{
			for(int j = i+1; j<arr.length ; j++)
			{
				if(arr[i]>arr[j])
				{
					int temp=arr[i];
					arr[i] = arr[j];
					arr[j]= temp;
				}
			}
		}
		System.out.println("Sorted Array : ");
		for(int i =0; i<arr.length ; i++)
		{
			System.out.println(arr[i]);
		}

	}

}
