import java.util.*;
class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        // ³����
        List<List<Integer>> resultL = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return resultL;
        }
        

        // ���Ƚ������������
        Arrays.sort(nums);
        
        for (int base = 0; base < nums.length - 2; base++) {
            // ѡ�����Ҷ�(��Сֵ)��Ϊbase, ����Сֵ>0 ʱ�� ���޺��ʵ�baseֵ������ѭ�����ҽ��� 
            if (nums[base] > 0) {
                break;
            }
            
            // base�ڵ��ȥ��
            if (base > 0 && nums[base] == nums[base - 1]) {
                    continue;
                }
                
            // �趨���˽ڵ�
            int L = base + 1;
            int R = nums.length - 1;
            while (L < R) {
                // ���˽ڵ��ȥ�ز���
                if (L > base + 1 && nums[L] == nums[L - 1]) {
                    L++;
                    continue;
                }
                if (R < nums.length - 1 && nums[R] == nums[R + 1]) {
                    R--;
                    continue;
                }
                
                // ���˽ڵ����м�ǰ���Ĺ���
                if (nums[base] + nums[L] + nums[R] > 0) {
                    R--;
                } else if (nums[base] + nums[L] + nums[R] < 0) {
                    L++;
                } else {
                    resultL.add(Arrays.asList(nums[base], nums[R], nums[L]));
                    R--;
                    L++;
                }
            }
        }
        return resultL;
    }
}


//����� ȥbase�ڵ��൱��ȷ���˶��صĵ�һ������ ��߽ڵ�����һ�����ص�С���� �ҽڵ�����һ�����صĴ����� ������ȥ�ص�ǰ�ᣬ û�����򣬱����󷨣�ȥ�ز����������ѡ�

// ʱ�临�Ӷ�n2, ����ѭ��Ƕ�ס������ʱ�临�Ӷȶ���n��
// �ռ临�Ӷ���1�� ֱ����ԭ�����ϲ�����
// ˫ָ��ͬʱ�߼�����һ��ѭ����������ʱ�临�Ӷȡ�


/* �����1 ³����δ���ؿ�List��������null;
   �����2 while���ж������� ������<�������ǣ�=;��Ϊ��������ѭ�������һ��
�ҵ�����ȷ���������� L�ڵ��R�ڵ��λ�ûύ�棬 ������==������Ӧ����ֹ����ѭ���޷�������ֹ��
   �����3 ���ҽڵ�ȥ�ص�Ŀ��������whileѭ���ڵ��ظ�����ڵ���ȥ�ص�����������L > base+1(while��ѭ���ĳ�ʼ��ڵ�),���ܰ�base����������
