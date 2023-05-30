def job_scheduling(jobs):
    jobs.sort(key=lambda x: x[1])

    current_time = 0
    total_lateness = 0

    for job in jobs:
        duration, deadline = job

        lateness = current_time - deadline
        total_lateness += lateness if lateness > 0 else 0

        current_time += duration

    return total_lateness

# User input for jobs
jobs = []
n = int(input("Enter the number of jobs: "))
for i in range(n):
    duration = int(input("Enter the duration of job {}: ".format(i + 1)))
    deadline = int(input("Enter the deadline of job {}: ".format(i + 1)))
    jobs.append((duration, deadline))

# Calculate total lateness
total_lateness = job_scheduling(jobs)
print("Total Lateness:", total_lateness)
